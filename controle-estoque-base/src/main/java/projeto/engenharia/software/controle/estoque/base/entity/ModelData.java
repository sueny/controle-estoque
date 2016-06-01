package projeto.engenharia.software.controle.estoque.base.entity;

/**
 *
 * @author Sueny
 * @param <T>
 */
public class ModelData<T> {
    
    private boolean success;
    private String msg;
    private T object;

    public ModelData(boolean success, T object) {
        this.success = success;
        this.object = object;
    } 

    public ModelData(boolean success, String msg, T object ){
        this.success = success;
        this.msg = msg;
        this.object = object;
    }
    
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
    
}
