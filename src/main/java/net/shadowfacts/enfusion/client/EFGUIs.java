package net.shadowfacts.enfusion.client;

import net.shadowfacts.enfusion.EnFusion;
import net.shadowfacts.enfusion.machine.grinder.BlockGrinder;
import nova.core.gui.ComponentEvent;
import nova.core.gui.Gui;
import nova.core.gui.GuiEvent;
import nova.core.gui.component.Button;
import nova.core.gui.component.Container;
import nova.core.gui.component.inventory.Slot;
import nova.core.gui.factory.GuiFactory;
import nova.core.gui.factory.GuiManager;
import nova.core.gui.layout.Anchor;
import nova.core.gui.layout.FlowLayout;

/**
 * @author shadowfacts
 */
public class EFGUIs {

	public static GuiFactory grinder;


	public static void registerGuis(GuiManager guiManager) {
		grinder = guiManager.register(() -> new Gui(EnFusion.id + ".gui.grinder")
						.add(
							new Button(EnFusion.id + ".gui.grinder.button1", "Button 1")
								.setMaximumSize(300, 100)
								.onEvent((event, component) -> {
									System.out.println("Test Button 1 pressed!");
								}, ComponentEvent.ActionEvent.class),
							Anchor.EAST
						)
						.add(
							new Container(EnFusion.id + ".gui.grinder.container")
								.setLayout(new FlowLayout())
								.add(new Slot(EnFusion.id + ".gui.grinder.inv", 0))
								.add(new Slot(EnFusion.id + ".gui.grinder.inv", 1))
						)
						.onGuiEvent((event) -> {
							event.gui.addInventory(EnFusion.id + ".gui.grinder.inv", ((BlockGrinder) event.block.get()).getInventory());
							System.out.println("Grinder GUI opened!");
						}, GuiEvent.BindEvent.class)
		);
	}

}
