package dev.thource.runelite.dudewheresmystuff;

import java.awt.event.KeyEvent;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Setter;
import net.runelite.client.input.KeyListener;

public class ItemCountInputListener implements KeyListener {

  @Setter @Nullable private ItemCountOverlay itemCountOverlay;
  private final DudeWheresMyStuffConfig dudeWheresMyStuffConfig;

  @Inject
  private ItemCountInputListener(DudeWheresMyStuffConfig dudeWheresMyStuffConfig) {
    this.dudeWheresMyStuffConfig = dudeWheresMyStuffConfig;
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {
    // not needed
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    if (itemCountOverlay == null || dudeWheresMyStuffConfig.storedItemCountTooltipKeybind() == null) {
      return;
    }

    if (dudeWheresMyStuffConfig.storedItemCountTooltipKeybind().matches(keyEvent)) {
      itemCountOverlay.setKeybindPressed(true);
    }
  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
    if (itemCountOverlay == null || dudeWheresMyStuffConfig.storedItemCountTooltipKeybind() == null) {
      return;
    }

    if (dudeWheresMyStuffConfig.storedItemCountTooltipKeybind().matches(keyEvent)) {
      itemCountOverlay.setKeybindPressed(false);
    }
  }
}
