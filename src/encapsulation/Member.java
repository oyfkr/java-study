package encapsulation;

public class Member {

    private final String name;
    private final int age;
    private final boolean admin;

    public Member(String name, int age, boolean admin) {
        this.name = name;
        this.age = age;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isSuperAdmin() {
        if(this.getAge() > 25 && this.isAdmin()) {
            return true;
        }

        return false;
    }
}
