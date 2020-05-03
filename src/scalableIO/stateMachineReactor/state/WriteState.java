package scalableIO.stateMachineReactor.state;

import scalableIO.stateMachineReactor.Handler;

public class WriteState extends AbstractChannelState  {

    private static final WriteState instance = new WriteState();

    private WriteState(){}

    public static WriteState getInstance(){
        return instance;
    }

    @Override
    public ChannelState getSate(Handler handler) {
         return ChannelState.WRITING;
    }


    @Override
    public void write(Handler handler) {

    }

}
