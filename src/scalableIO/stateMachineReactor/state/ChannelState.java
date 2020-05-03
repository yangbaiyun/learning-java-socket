package scalableIO.stateMachineReactor.state;

import java.nio.channels.SelectionKey;

/**
 * channel 状态
 */
public enum ChannelState {

    //请求连接状态
    CONNECTING(0),
    //读取状态
    READING(SelectionKey.OP_READ),
    //处理状态
    PROCESSING(2),
    //写状态
    WRITING(SelectionKey.OP_WRITE);

    private final int opBit;
    private ChannelState(int operateBit){
        opBit = operateBit;
    }

    public int getOpBit() {
        return opBit;
    }
}
