package scalableIO.stateMachineReactor.state;

import scalableIO.stateMachineReactor.Handler;

import java.io.IOException;

import static scalableIO.Logger.log;

public abstract class AbstractChannelState implements IChannelState {



    @Override
    public void connect(Handler handler) {

    }

    @Override
    public void read(Handler handler) {

    }

    @Override
    public void process(Handler handler) {

    }

    @Override
    public void write(Handler handler) {

    }

    protected void disconnect(Handler handler){
        try {
            handler.getClientChannel().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("\nclient Address=【"+handler.getClientChannel().socket().getRemoteSocketAddress()+"】 had already closed!!! ");
    }




}
