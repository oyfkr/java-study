package encapsulation;

public class Logic {

    public String getSuperAdmin() {
        Member kevin = new Member("kevin", 30, true);

        if(kevin.getAge() > 25 && kevin.isAdmin()) {
            return "super admin";
        }

        return "just admin";
    }

    public String getSuperAdminWithEncapsulation() {
        Member kevin = new Member("kevin", 30, true);

        if(kevin.isSuperAdmin()) {
            return "super admin";
        }

        return "just admin";
    }
}
