package scalableIO.stateMachineReactor.state;


import scalableIO.stateMachineReactor.Handler;

/**
 * 定义所有状态类的接口
 */
public interface IChannelState {


    ChannelState getSate(Handler handler);
    //所有事件
    void connect(Handler handler);

    void read(Handler handler);

    void process(Handler handler);

    void write(Handler handler);


}
