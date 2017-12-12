package entity;

public class Category {
    public int id;
    public String name;
    public int recordNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    /**
     * 返回消费分类名称
     * @return
     */
    @Override
    public String toString() {
        return name;
    }
}
