package hsbc.team03.ordersystem.displayproduct.model;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author:Evan
 * @Date:2018/8/6 13:46
 * @Return:
 * @Param:
 */
@Entity
public class Log {
    @Id
    private String id;
    /**
     * operate name
     */
    private String name;
    /**
     * operate time
     */
    private String time;
    /**
     * operate what
     */
    private String operation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
