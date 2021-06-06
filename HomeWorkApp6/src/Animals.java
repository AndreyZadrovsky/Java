abstract class Animals {
    public String name;
    public int loRun;
    public int loSwim;

    public Animals(String name, int loRun, int loSwim) {
        this.name = name;
        this.loRun = loRun;
        this.loSwim = loSwim;
    }

    abstract void Run(int loSwim);

    abstract void Swim(int loRun);
}

