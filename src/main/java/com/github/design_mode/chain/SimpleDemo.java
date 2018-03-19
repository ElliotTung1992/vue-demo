package com.github.design_mode.chain;


/**
 * 责任链模式
 */
public class SimpleDemo {

    public static void main(String[] args) {

        Handler departmentManager = new DepartmentManager();
        Handler generalManager = new GeneralManager();
        Handler boss = new Boss();

        departmentManager.setSuperHandler(generalManager);
        generalManager.setSuperHandler(boss);

        Response response = departmentManager.handlerRequest(new LeaveRequest(new LeaveDays(3)));
        if(response != null){
            System.out.println(response.getMessage());
        }
        Response response1 = departmentManager.handlerRequest(new LeaveRequest(new LeaveDays(8)));
        if(response1 != null){
            System.out.println(response1.getMessage());
        }
        Response response2 = departmentManager.handlerRequest(new LeaveRequest(new LeaveDays(15)));
        if(response2 != null){
            System.out.println(response2.getMessage());
        }
        Response response3 = departmentManager.handlerRequest(new LeaveRequest(new LeaveDays(33)));
        if(response3 != null){
            System.out.println(response3.getMessage());
        }
    }

}

//请假请求
class LeaveRequest {

    LeaveDays leaveDays;

    public LeaveRequest(LeaveDays leaveDays){
        this.leaveDays = leaveDays;
    }

    public LeaveDays getLevel(){
        return leaveDays;
    }
}

//响应
class Response {

    private String message;

    public Response(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

//请假天数
class LeaveDays {

    private int days = 0;

    public LeaveDays(int days){
        this.days = days;
    }

    public int getDays(){
        return days;
    }

    public boolean compare(LeaveDays leaveDays){
        if(this.days >= leaveDays.getDays()){
            return true;
        }else{
            return false;
        }
    }
}

//执行接口
abstract class Handler{

    //上级
    private Handler superHandler = null;

    //设置上级
    public void setSuperHandler(Handler superHandler){
        this.superHandler = superHandler;
    }

    //处理请求
    public Response handlerRequest(LeaveRequest leaveRequest){
        if(this.getHandlerLevel().compare(leaveRequest.leaveDays)){
            return this.execute(leaveRequest);
        }else{
            if(superHandler != null){
                return superHandler.handlerRequest(leaveRequest);
            }else{
                System.out.println("...不批");
            }
        }
        return null;
    }

    //执行
    abstract Response execute(LeaveRequest leaveRequest);

    //获取执行器等级
    abstract LeaveDays getHandlerLevel();
}

//部门经理
class DepartmentManager extends Handler{

    @Override
    Response execute(LeaveRequest leaveRequest) {
        return new Response("部门经理批准请假: " + leaveRequest.leaveDays.getDays() + "天");
    }

    @Override
    LeaveDays getHandlerLevel() {
        return new LeaveDays(5);
    }
}

//总经理
class GeneralManager extends Handler{

    @Override
    Response execute(LeaveRequest leaveRequest) {
        return new Response("总经理批准请假: " + leaveRequest.leaveDays.getDays() + "天");
    }

    @Override
    LeaveDays getHandlerLevel() {
        return new LeaveDays(10);
    }
}

//老板
class Boss extends Handler{

    @Override
    Response execute(LeaveRequest leaveRequest) {
        return new Response("老板批准请假: " + leaveRequest.leaveDays.getDays() + "天");
    }

    @Override
    LeaveDays getHandlerLevel() {
        return new LeaveDays(20);
    }
}
