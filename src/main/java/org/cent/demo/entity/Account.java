package org.cent.demo.entity;

public class Account {
    private String id;
    private long number;
    private String name;
    private String createAt;
    private String updateAt;
    private int version;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{id: ");
        sb.append(id);
        sb.append(", number: ");
        sb.append(number);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", creatAt: ");
        sb.append(createAt);
        sb.append(", updateAt: ");
        sb.append(updateAt);
        sb.append(", version: ");
        sb.append(version);
        sb.append("}");
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
