package scalableIO.stateMachineReactor.state;

import scalableIO.stateMachineReactor.Handler;

import java.io.IOException;
import java.util.Arrays;

import static scalableIO.Logger.log;

public class ReadState extends AbstractChannelState  {

    private static final ReadState instance = new ReadState();

    private ReadState(){}

    public static ReadState getInstance(){
        return instance;
    }

    @Override
    public ChannelState getSate(Handler handler) {
        return ChannelState.READING;
    }

    @Override
    public void read(Handler handler) {
        int readSize;
        try {
            while((readSize = handler.getClientChannel().read(handler.getReadBuf())) > 0){
                handler.getReadData().append(new String(Arrays.copyOfRange(handler.getReadBuf().array(), 0, readSize)));
                handler.getReadBuf().clear();
            }
            if(readSize == -1){
                disconnect(handler);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            disconnect(handler);
        }

        log("readed from client:"+handler.getReadData()+", "+handler.getReadData().length());
    }





}
