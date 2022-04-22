package businesslogic;

import java.util.ArrayList;

/**
 * Kezeli az egész játékot. Létrehozza a szükséges elemeket, elindítja, majd ha valamelyik játékos nyert, befejezi a játékot.
 * @attribute single_instance a játék egyetlen példánya
 */
public class Game {
    private static Game single_instance = null;

    /**
     * Elindítja a játékot.
     */
    public void startGame() {
        // jatek kezdes
    }

    /**
     * Befejezi a játékot.
     */
    public void endGame() {
        // jatek vege
    }

    public void WriteJson(){
        JSONObject jsonObject = new JSONObject();
        if (field.GetActiveSettler() != null)
            jsonObject.put("ActiveSettler", field.GetActiveSettler().GetName());
        else
            jsonObject.put("ActiveSettler", "NULL");

        /**
         * innentol a keringo objektumok felepitese
         */
        JSONObject orbitingObjectsJson = new JSONObject();

        /**
         * bazis aszteroida
         */
        JSONObject baseAsteroidJson = new JSONObject();
        if (base != null) {
            baseAsteroidJson.put("xCoordinate", base.GetPosition().GetX());
            baseAsteroidJson.put("yCoordinate", base.GetPosition().GetY());
            baseAsteroidJson.put("thickness", base.GetThickness());

            /**
             * chest tartalma
             */
            JSONArray chestJson = new JSONArray();
            ArrayList<String> chestItemNames = new ArrayList<>();


            for (Material material : base.GetChest())
            {
                chestItemNames.add(material.GetName());
            }
            chestJson.putAll(chestItemNames);
            baseAsteroidJson.put("chest", chestJson);


            /**
             *  bazis szomszedai
             */
            JSONArray baseNeighboursJson = new JSONArray();
            ArrayList<String> baseNeighboursNames = new ArrayList<>();


            for (OrbitingObject neighbour : base.GetNeighbors())
            {
                baseNeighboursNames.add(neighbour.GetName());
            }
            baseNeighboursJson.putAll(baseNeighboursNames);
            baseAsteroidJson.put("neighbours", baseNeighboursJson);

            orbitingObjectsJson.put("BaseAsteroid", baseAsteroidJson);
        } else {
            orbitingObjectsJson.put("BaseAsteroid", "NULL");
        }

        /**
         * lista az aszteroidakrol
         */
        JSONArray asteroidListJson = new JSONArray();

        for (Ellipse2D ellipse : field.GetEllipses()) {
            for (OrbitingObject orbitingObject : ellipse.GetObjects()) {
                if (orbitingObject.getClass() == Asteroid.class){
                    JSONObject asteroidJson = new JSONObject();
                    asteroidJson.put("xCoordinate", orbitingObject.GetPosition().GetX());
                    asteroidJson.put("yCoordinate", orbitingObject.GetPosition().GetY());
                    asteroidJson.put("thickness", orbitingObject.GetThickness());
                    asteroidJson.put("ellipse", ellipse.GetId());

                    JSONArray neighboursJson = new JSONArray();
                    ArrayList<String> neighboursNames = new ArrayList<>();

                    for (OrbitingObject neighbour : orbitingObject.GetNeighbors())
                    {
                        neighboursNames.add(neighbour.GetName());
                    }
                    neighboursJson.putAll(neighboursNames);

                    asteroidJson.put("neighbours", neighboursJson);
                    if(orbitingObject.GetMaterial() == null){
                        asteroidJson.put("material", "NULL");
                    }else {
                        asteroidJson.put("material", orbitingObject.GetMaterial().GetName());
                    }
                    asteroidJson.put("closeToSun", orbitingObject.IsCloseToSun());

                    JSONObject asteroidJsonWrapper = new JSONObject();
                    asteroidJsonWrapper.put(orbitingObject.GetName(), asteroidJson);
                    asteroidListJson.put(asteroidJsonWrapper);
                }
            }
        }

        orbitingObjectsJson.put("Asteroids:", asteroidListJson);

        /**
         * lista a teleportkapukrol
         */
        JSONArray teleportGateListJson = new JSONArray();

        for (Ellipse2D ellipse : field.GetEllipses()) {
            for (OrbitingObject orbitingObject : ellipse.GetObjects()) {
                if (orbitingObject.getClass() == TeleportGate.class){
                    JSONObject teleportGateJson = new JSONObject();
                    teleportGateJson.put("xCoordinate", orbitingObject.GetPosition().GetX());
                    teleportGateJson.put("yCoordinate", orbitingObject.GetPosition().GetY());


                    JSONArray neighboursJson = new JSONArray();
                    ArrayList<String> neighboursNames = new ArrayList<>();

                    for (OrbitingObject neighbour : orbitingObject.GetNeighbors())
                    {
                        neighboursNames.add(neighbour.GetName());
                    }
                    neighboursJson.putAll(neighboursNames);

                    teleportGateJson.put("neighbours", neighboursJson);
                    teleportGateJson.put("active", ((TeleportGate) orbitingObject).IsActive());

                    teleportGateJson.put("closeToSun", orbitingObject.IsCloseToSun());
                    teleportGateJson.put("pair", ((TeleportGate)orbitingObject).GetPair().GetName());

                    JSONObject teleportGateJsonWrapper = new JSONObject();
                    teleportGateJsonWrapper.put(orbitingObject.GetName(), teleportGateJson);
                    teleportGateListJson.put(teleportGateJsonWrapper);
                }
            }
        }

        orbitingObjectsJson.put("TeleportGates:", teleportGateListJson);

        jsonObject.put("OrbitingObjects", orbitingObjectsJson);

        /**
         * lista a telepesekrol
         */
        JSONArray settlerListJson = new JSONArray();

        if(base != null) {
            for (Worker worker : base.GetWorkers()) {
                if (worker.getClass() == Settler.class) {
                    JSONObject settlerJson = new JSONObject();

                    /**
                     * material inventory
                     */
                    JSONArray inventoryJson = new JSONArray();
                    ArrayList<String> inventoryNames = new ArrayList<>();
                    for (Material material : ((Settler) worker).GetBackpack()) {
                        inventoryNames.add(material.GetName());
                    }
                    inventoryJson.putAll(inventoryNames);
                    settlerJson.put("inventory", inventoryJson);

                    /**
                     *  teleportGate inventory
                     */
                    JSONArray teleportGateJson = new JSONArray();
                    ArrayList<String> teleportGateNames = new ArrayList<>();
                    for (TeleportGate teleportGate : ((Settler) worker).GetGateInventory()) {
                        teleportGateNames.add(teleportGate.GetName());
                    }
                    teleportGateJson.putAll(teleportGateNames);
                    settlerJson.put("teleportGateInventory", teleportGateNames);

                    settlerJson.put("location", worker.location.GetName());

                    JSONObject settlerJsonWrapper = new JSONObject();
                    settlerJsonWrapper.put(worker.GetName(), settlerJson);
                    settlerListJson.put(settlerJsonWrapper);
                }
            }
        }
        for (Ellipse2D ellipse : field.GetEllipses()) {
            for (OrbitingObject orbitingObject : ellipse.GetObjects()) {
                for (Worker worker : orbitingObject.GetWorkers()) {
                    if (worker.getClass() == Settler.class) {
                        JSONObject settlerJson = new JSONObject();

                        /**
                         * material inventory
                         */
                        JSONArray inventoryJson = new JSONArray();
                        ArrayList<String> inventoryNames = new ArrayList<>();
                        for (Material material : ((Settler) worker).GetBackpack()) {
                            inventoryNames.add(material.GetName());
                        }
                        inventoryJson.putAll(inventoryNames);
                        settlerJson.put("inventory", inventoryJson);

                        /**
                         *  teleportGate inventory
                         */
                        JSONArray teleportGateJson = new JSONArray();
                        ArrayList<String> teleportGateNames = new ArrayList<>();
                        for (TeleportGate teleportGate : ((Settler) worker).GetGateInventory()) {
                            teleportGateNames.add(teleportGate.GetName());
                        }
                        teleportGateJson.putAll(teleportGateNames);
                        settlerJson.put("teleportGateInventory", teleportGateNames);

                        settlerJson.put("location", worker.location.GetName());

                        JSONObject settlerJsonWrapper = new JSONObject();
                        settlerJsonWrapper.put(worker.GetName(), settlerJson);
                        settlerListJson.put(settlerJsonWrapper);
                    }
                }
            }
        }

        jsonObject.put("Settlers", settlerListJson);

        /**
         *  lista a robotokrol
         */

        JSONArray robotListJson = new JSONArray();

        for (Ellipse2D ellipse : field.GetEllipses()) {
            for (OrbitingObject orbitingObject : ellipse.GetObjects()) {
                for (Worker worker : orbitingObject.GetWorkers()) {
                    if (worker.getClass() == Robot.class) {
                        JSONObject robotJson = new JSONObject();
                        robotJson.put("location", worker.location.GetName());

                        JSONObject robotJsonWrapper = new JSONObject();
                        robotJsonWrapper.put(worker.GetName(), robotJson);
                        robotListJson.put(robotJsonWrapper);
                    }
                }
            }
        }

        jsonObject.put("Robots", robotListJson);

        /**
         * lista az ufokrol
         */
        JSONArray ufoListJson = new JSONArray();

        for (Ellipse2D ellipse : field.GetEllipses()) {
            for (OrbitingObject orbitingObject : ellipse.GetObjects()) {
                for (Worker worker : orbitingObject.GetWorkers()) {
                    if (worker.getClass() == Ufo.class) {
                        JSONObject ufoJson = new JSONObject();
                        ufoJson.put("location: ", worker.location.GetName());

                        JSONObject ufoJsonWrapper = new JSONObject();
                        ufoJsonWrapper.put(worker.GetName(), ufoJson);
                        ufoListJson.put(ufoJsonWrapper);
                    }
                }
            }
        }

        jsonObject.put("Ufos", ufoListJson);

        /**
         * lista a solarStromokrol
         */
        JSONArray solarStormListJson = new JSONArray();

        for (SolarStorm solarStorm : field.GetSun().GetSolarStorms()) {
            JSONObject solarStormJson = new JSONObject();
            solarStormJson.put("angle", solarStorm.GetAngle());
            solarStormJson.put("warnTimer", solarStorm.GetWarnTimer());

            JSONObject solarStormJsonWrapper = new JSONObject();
            solarStormJsonWrapper.put(solarStorm.GetName(), solarStormJson);
            solarStormListJson.put(solarStormJsonWrapper);
        }

        jsonObject.put("Solarstorms", solarStormListJson);

        System.out.println(jsonObject.toString(4));

    }
}
