package com.mi.game.module.event.handler;

import com.mi.core.engine.IOMessage;
import com.mi.core.engine.ModuleManager;
import com.mi.core.engine.annotation.HandlerType;
import com.mi.game.defines.HandlerIds;
import com.mi.game.defines.ModuleNames;
import com.mi.game.module.base.handler.BaseHandler;
import com.mi.game.module.event.EventModule;
import com.mi.game.module.event.protocol.EventDrawPayProtocol;

@HandlerType(type = HandlerIds.EVENT_DRAW_PAY_DATA)
public class EventDrawPayDataHandler extends BaseHandler {

	@Override
	public void execute(IOMessage ioMessage) {
								
		EventModule eventModule = ModuleManager.getModule(ModuleNames.EventModule, EventModule.class);
		EventDrawPayProtocol protocol = new EventDrawPayProtocol();
		eventModule.eventGetDrawPayData(protocol);
		ioMessage.setOutputResult(protocol);
	}
}
