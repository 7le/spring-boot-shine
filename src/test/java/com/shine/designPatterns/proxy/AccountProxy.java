package com.shine.designPatterns.proxy;

/**
 * 代理类（增强AccountImpl的功能）
 * Created by 7le on 2017/5/4 0004.
 */
public class AccountProxy implements Account{

    private AccountImpl accountImpl;

    /**
     * 重写默认构造函数
     * @param accountImpl :真正要执行业务的对象
     */
    public AccountProxy(AccountImpl accountImpl) {
        this.accountImpl =accountImpl;
    }

    @Override
    public void queryAccount() {
        System.out.println("业务处理之前...");
        // 调用委托类的方法，这是具体的业务方法
        accountImpl.queryAccount();
        System.out.println("业务处理之后...");
    }

    @Override
    public void updateAccount() {
        System.out.println("业务处理之前...");
        // 调用委托类的方法;
        accountImpl.updateAccount();
        System.out.println("业务处理之后...");
    }

    public static void main(String[] args) {
        AccountImpl accountImpl = new AccountImpl();
        //在这里传入要调用的业务对象
        AccountProxy accountProxy = new AccountProxy(accountImpl);
        //开始调用业务对象的方法，这两个方法都被增强了。
        accountProxy.updateAccount();
        accountProxy.queryAccount();

        //多个接口代理,就引入了动态代理,可以看spring的DynamicAopProxy
    }

}