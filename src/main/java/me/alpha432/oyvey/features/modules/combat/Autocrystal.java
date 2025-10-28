import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class CrystalAuraExample {

    private final PlayerEntity player;
    private final double range;

    public CrystalAuraExample(PlayerEntity player, double range) {
        this.player = player;
        this.range = range;
    }

    public void tick(World world) {
        // Define a detection box around the player
        AxisAlignedBB box = player.getBoundingBox().grow(range);

        // Find all End Crystals in range
        List<EntityEnderCrystal> crystals = world.getEntitiesWithinAABB(EntityEnderCrystal.class, box);

        for (EntityEnderCrystal crystal : crystals) {
            if (player.getDistance(crystal) <= range) {
                interactWithCrystal(crystal);
            }
        }
    }

    private void interactWithCrystal(EntityEnderCrystal crystal) {
        // Example: trigger particle effect or custom action
        crystal.setCustomNameVisible(true);
        crystal.setCustomName(player.getDisplayName().append(" found me!"));
    }
}
