package org.zonedabone.megacatch;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropFish implements Listener{

	private boolean dropedFish = false;

	// method for the reset timer to reset dropedFish to false.
	public void setDropedFish(boolean dropedFish) {
		this.dropedFish = dropedFish;
	}

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {
			if (event.getItemDrop().getItemStack().getTypeId() == 349) {
				new DropReset(60); // resets dropedFish to false after 60
									// seconds.
				dropedFish = true;
			}
			
		}

	public boolean isDropedFish() {
		return dropedFish;
	}

	// Declaration of a Timer, to reset the value dropedFish
	public class DropReset {
		Timer timer;

		public DropReset(int seconds) {
			timer = new Timer();
			timer.schedule(new RemindTask(), seconds * 1000);
		}

		// Declaration of the timer and its method.
		class RemindTask extends TimerTask {
			public void run() {
				setDropedFish(false);
			}
		}
	}
}
