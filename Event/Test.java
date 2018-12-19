// package client;

// import callbackIml.EventService;
// import callbackIml.EventCallback;
// import callbackIml.EventEmitter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventEmitter event = new EventEmitter();

		event.on("click", new EventCallback() {

			@Override
			public void callback(EventService e) {

				System.out.println("click...");

				e.trigger("mouseover");
			}
		});

		event.on("mouseover", new EventCallback() {

			@Override
			public void callback(EventService es) {

				System.out.println("mouseover..." + es);
			}
		});
		event.trigger("mouseover");
		event.trigger("click");

	}

}

// 总结： 主要基于观察者的设计模式。采用客户端和服务端分离的思想。
// 使用函数“on”对客户端的回调函数callback进行注册。
// 采用callbackLIst对同一个事件上的回调函数进行存储。
// 最后把每个事件所对应的各自的回调函数列表映射到map中。