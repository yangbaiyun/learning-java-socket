package scalableIO.stateMachineReactor.state;

import scalableIO.stateMachineReactor.Handler;

public class ProcessState extends AbstractChannelState  {

    private static final ProcessState instance = new ProcessState();

    private ProcessState(){}

    public static ProcessState getInstance(){
        return instance;
    }


    @Override
    public ChannelState getSate(Handler handler) {
        return ChannelState.PROCESSING;
    }


    @Override
    public void process(Handler handler) {

    }

}
