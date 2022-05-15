package businesslogic;

/**
 * védőfelszerelés amely az ágenseket 82,3%-os hatásfokkal tartja távol
 */
public class Gloves extends Equipment {
    int EffectTime;
    /**
     * @param by - virologus akié lesz a felszerelés
     */
    @Override
    public void taken(Virologist by) {
        by.setHasGloves(this);
    }

    public Gloves()
    {
        super();
        this.EffectTime=3;
        this.name = "Gloves";
    }

    public Gloves(String name)
    {
        super();
        this.EffectTime=3;
        this.name=name;
    }

    public void SetEffectTime(int num)
    {
        this.EffectTime=num;
    }

    public void reduceLifeTime() {
        EffectTime--;
    }

}
