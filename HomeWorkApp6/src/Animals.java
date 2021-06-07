abstract class Animals {
    public String name;
    public int loRun;
    public int loSwim;
    public int lim;
    public Animals(String name, int loRun, int loSwim, int lim) {
        this.name = name;
        this.loRun = loRun;
        this.loSwim = loSwim;
        this.lim = lim;
    }

    public void Run(int loRun) {
        if (this.loRun > this.lim) {
            System.out.println(this.name + " не может пробежать " + this.loRun + " м.");
        } else {
            System.out.println(this.name + " пробежал " + this.loRun + " м.");
        }
    }
    abstract void Swim(int loRun);
}

