package scalableIO.stateMachineReactor.echo;

import scalableIO.stateMachineReactor.Acceptor;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class EchoAcceptor extends Acceptor {

	EchoAcceptor(Selector selector, ServerSocketChannel serverChannel, boolean useMultipleReactors){
		super(selector, serverChannel, useMultipleReactors);
	}
	
	@Override
	public void handle(Selector selector, SocketChannel clientChannel) {
		new EchoHandler(selector, clientChannel).run();
	}

}
