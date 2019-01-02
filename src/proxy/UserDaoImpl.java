package proxy;

/**
 * UserDaoImpl
 * 接口实现
 * 目标对象
 * @author Mr Li
 * @date 2018/12/14
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {

        System.out.println("--------已经保存数据---------");
    }

    @Override
    public void update() {
        System.out.println("---------已经更新了一条数据-------");
    }
}
