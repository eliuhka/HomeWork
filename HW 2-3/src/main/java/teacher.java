class Teacher extends PersonImpl{
    public String name;
    public String surname;
    public int age;
    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("Hello");}
    @Override
    public String getFirstName() {
        return name;}

}