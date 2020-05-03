package scalableIO.stateMachineReactor.echo;

import scalableIO.stateMachineReactor.ServerContext;
import scalableIO.stateMachineReactor.Acceptor;
import scalableIO.stateMachineReactor.Reactor;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class EchoReactor extends Reactor {
	
	public EchoReactor(int port, ServerSocketChannel serverChannel, boolean isMainReactor, boolean useMultipleReactors, long timeout){
		super(port, serverChannel, isMainReactor, useMultipleReactors, timeout);
	}

	@Override
	public Acceptor newAcceptor(Selector selector) {
		return new EchoAcceptor(selector, serverChannel, useMultipleReactors);
	}
	
	public static void main(String[] args) throws IOException {
		//new EchoReactor(9003, ServerSocketChannel.open(), true, false, TimeUnit.MILLISECONDS.toMillis(10)).start();
		//ServerContext.startMultipleReactor(9004, EchoReactor.class);
		ServerContext.startSingleReactor(9004, EchoReactor.class);
	}

}
