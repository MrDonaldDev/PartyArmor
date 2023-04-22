package party.armor.partyarmor;


import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

public final class PartyArmor extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getScheduler()
                .runTaskTimer(this, new ArmorColourChange(), 20, 20 * 2);
        System.out.println("Everything works!");
    }

    private static class ArmorColourChange implements Runnable {

        private static final org.bukkit.Color[] COLOURS = new Color[]{Color.RED, Color.ORANGE,
                Color.YELLOW, Color.LIME, Color.AQUA, Color.BLUE, Color.PURPLE,
                Color.FUCHSIA};

        private static final org.bukkit.Color[] COLOURS2 = new Color[]{Color.FUCHSIA, Color.PURPLE,
                Color.BLUE, Color.AQUA, Color.LIME, Color.YELLOW, Color.ORANGE,
                Color.RED};

        private static final org.bukkit.Color[] COLOURS3 = new Color[]{Color.PURPLE, Color.AQUA,
                Color.LIME, Color.YELLOW, Color.ORANGE, Color.FUCHSIA, Color.RED,
                Color.BLUE};

        private static final org.bukkit.Color[] COLOURS4 = new Color[]{Color.BLUE, Color.LIME,
                Color.AQUA, Color.ORANGE, Color.YELLOW, Color.RED, Color.FUCHSIA,
                Color.PURPLE};

        int currentArrayIndex = 0;

        @Override
        public void run() {
            final int index = currentArrayIndex % COLOURS.length;
            // Helmet
            Bukkit.getOnlinePlayers()
                    .stream()
                    .filter(player -> player.getInventory().getHelmet() != null
                            && player.getInventory().getHelmet().getType()
                            == Material.LEATHER_HELMET)
                    .forEach(player -> {
                        ItemStack item = player.getInventory().getHelmet();
                        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta()
                                : Bukkit.getItemFactory().getItemMeta(item.getType());
                        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
                        leatherArmorMeta.setColor(COLOURS[index]);
                        item.setItemMeta(meta);
                        player.getInventory().setHelmet(item);
                    });

            currentArrayIndex++;
            // Chestplate
            Bukkit.getOnlinePlayers()
                    .stream()
                    .filter(player -> player.getInventory().getChestplate() != null
                            && player.getInventory().getChestplate().getType()
                            == Material.LEATHER_CHESTPLATE)
                    .forEach(player -> {
                        ItemStack item2 = player.getInventory().getChestplate();
                        ItemMeta meta2 = item2.hasItemMeta() ? item2.getItemMeta()
                                : Bukkit.getItemFactory().getItemMeta(item2.getType());
                        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta2;
                        leatherArmorMeta.setColor(COLOURS2[index]);
                        item2.setItemMeta(meta2);
                        player.getInventory().setChestplate(item2);
                    });
            // Leggings
            Bukkit.getOnlinePlayers()
                    .stream()
                    .filter(player -> player.getInventory().getLeggings() != null
                            && player.getInventory().getLeggings().getType()
                            == Material.LEATHER_LEGGINGS)
                    .forEach(player -> {
                        ItemStack item3 = player.getInventory().getLeggings();
                        ItemMeta meta3 = item3.hasItemMeta() ? item3.getItemMeta()
                                : Bukkit.getItemFactory().getItemMeta(item3.getType());
                        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta3;
                        leatherArmorMeta.setColor(COLOURS3[index]);
                        item3.setItemMeta(meta3);
                        player.getInventory().setLeggings(item3);
                    });
            // Boots
            Bukkit.getOnlinePlayers()
                    .stream()
                    .filter(player -> player.getInventory().getBoots() != null
                            && player.getInventory().getBoots().getType()
                            == Material.LEATHER_BOOTS)
                    .forEach(player -> {
                        ItemStack item4 = player.getInventory().getBoots();
                        ItemMeta meta4 = item4.hasItemMeta() ? item4.getItemMeta()
                                : Bukkit.getItemFactory().getItemMeta(item4.getType());
                        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta4;
                        leatherArmorMeta.setColor(COLOURS4[index]);
                        item4.setItemMeta(meta4);
                        player.getInventory().setBoots(item4);
                    });
        }
    }




    @Override
    public void onDisable() {
        System.out.println("Byebye :(");
    }
}
