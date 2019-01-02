package proxy;

/**
 * UserDaoProxy
 *
 * @author Mr Li
 * @date 2018/12/14
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao target;
    public UserDaoProxy(IUserDao target) {
        this.target=target;
    }

    @Override
    public void save() {
        System.out.println("----开始事务-----");
        target.save();
        System.out.println("----结束事务-----");
    }

    @Override
    public void update() {
        System.out.println("----开始事务2-----");
        target.update();
        System.out.println("----结束事务2-----");
    }
}
