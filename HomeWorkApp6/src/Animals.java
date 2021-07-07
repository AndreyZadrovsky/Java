abstract class Animals {
    public String name;
    public int lim;
    public Animals(String name, int lim) {
        this.name = name;
        this.lim = lim;
    }

    public void Run(int loRun) {
        if (loRun > this.lim) {
            System.out.println(this.name + " не может пробежать " + loRun + " м.");
        } else {
            System.out.println(this.name + " пробежал " + loRun + " м.");
        }
    }
    abstract void Swim(int loRun);
}

