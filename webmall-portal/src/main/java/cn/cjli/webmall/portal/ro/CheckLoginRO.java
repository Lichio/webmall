package cn.cjli.webmall.portal.ro;

/**
 * WebMall cn.cjli.webmall.portal.ro
 *
 * @author lichaojie
 * @version 2019-06-12 12:04
 */
public class CheckLoginRO {
    private String role;

    private long id;

    public String getRole() {
        return role;
    }

    public CheckLoginRO setRole(String role) {
        this.role = role;
        return this;
    }

    public long getId() {
        return id;
    }

    public CheckLoginRO setId(long id) {
        this.id = id;
        return this;
    }
}
