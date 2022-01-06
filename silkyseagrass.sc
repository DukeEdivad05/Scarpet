//You can obtaining seagrass breaking it with a pickaxe enchanted with silktouch
//By BisUmTo & DukeEdivad05

__config() -> {'stay_loaded' -> true, 'scope' -> 'global'};

global_drop_in_creative = true;

_holds_enchant(player, enchant) -> (
    item = player ~ 'holds';
    if(!item || !(nbt = item:2), return(false));
    if(!(ench = get(nbt, 'Enchantments[]')), return(false));
    if(type(ench) != 'list', ench = [ench]);
    for(ench, if (_: 'id' == 'minecraft:' + enchant, return(true)));
    false);

__on_player_breaks_block(player, block) -> (
    if(_holds_enchant(player, 'silk_touch'),
    itempos=pos(block)+[0.5,0.25,0.5];
    if(block == 'seagrass',
    spawn('item',itempos,'{PickupDelay:10,Item:{id:"minecraft:seagrass",Count:1b}}'),
    if(block == 'tall_seagrass',
    spawn('item',itempos,'{PickupDelay:10,Item:{id:"minecraft:seagrass",Count:2b}}')))))