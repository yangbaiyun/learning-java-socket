package scalableIO.stateMachineReactor.state;

import scalableIO.stateMachineReactor.Handler;

public class ConnectState extends AbstractChannelState  {


   private static final ConnectState instance = new ConnectState();

   private ConnectState(){}

   public static ConnectState getInstance(){
       return instance;
   }

    @Override
    public ChannelState getSate(Handler handler) {
        return ChannelState.CONNECTING;
    }

    @Override
    public void connect(Handler handler) {

        handler.setChannelState(ChannelState.READING);
        handler.getKey().interestOps(handler.getChannelState().getOpBit());

    }


}
