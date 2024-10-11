public class DenMørkeSkov {

    private Room currentRoom;

    public void buildMap() {
        //De forskellige rum
        //Room 1
        Room room1 = new Room("", "The starting point of your journey. The air is thick with tension as you step into the Dark Forest.\nThe trees tower above, and a strange silence surrounds you. There are no enemies here, but the ominous atmosphere warns of the dangers that lie ahead.,", "2 doors");

        //Weapons
        Weapon sword = new MeleeWeapon("sword", "Made out of valyrian steel - damage 20", 200, "\u2694\uFE0F");
        room1.addItems(sword);

        //Food
        Item staleBread = new Food("Stale Bread", "An old loaf of bread that has lost its freshness - health -5", -5, "\uD83C\uDF5E");
        room1.addItems(staleBread);

        //Room 2
        Room room2 = new Room("Foggy Clearing ", "A dimly lit open space where the fog is so thick it’s hard to see.\nShadows move in the mist, and something seems to be watching you. ", "2 doors ");

        //Food
        Item herb = new Food("Herb", "Is a fragrant herb that heals wounds and soothes the soul - health 40", 40, "\uD83C\uDF3F");
        room2.addItems(herb);
        Item wildBerries = new Food("Berries", "Wild Berries is A handful of berries found in the wild - health +10", 10, "\uD83C\uDF4D");
        room2.addItems(wildBerries);

        //Weapons
        Weapon mistyDagger = new MeleeWeapon("Dagger", "The Misty Dagger is A lightweight dagger that seems to fade in and out of sight, perfect for stealth attacks.", 10, "\uD83D\uDDE1");
        Weapon phantomBlaster = new RangedWeapon("Blaster", "The Phantom Blaster is A mysterious gun that fires glowing projectiles through the fog.", 15,6, "\uD83D\uDD2B");
        room2.addItems(mistyDagger);
        room2.addItems(phantomBlaster);

        //Enemies
        Weapon fogBlade = new MeleeWeapon("Blade","The Fog Blade is A sharp, intangible blade formed from the mist.",15,"\\uD83C\\uDF2B");
        Enemy mistPhantom = new Enemy("Phantom", "A ghostly figure emerging from the fog, its presence chilling you to the bone.",40,this,fogBlade);
        room2.addEnemy(mistPhantom);

        Weapon claws = new MeleeWeapon("Claws","Vaporous claws that tear through flesh with ease.",30,"\\uD83D\\uDC3E");
        Enemy vaporFiend = new Enemy("VaporFiend","A creature of condensed vapor, it drifts silently before striking with ferocity.",45,this,claws);
        room2.addEnemy(vaporFiend);

        //Room 3
        Room room3 = new Room("Haunted Creek ", "A slow-moving stream runs through this area, but the water is black as night.\nGhostly figures drift above the surface, silently watching. ", "2 exits ");
        Weapon bow = new RangedWeapon("bow", "Green bow with magic arrows - damage 25", 25, 3, "\uD83C\uDFF9");
        room3.addItems(bow);

        //Weapons
        Weapon drownedHook = new MeleeWeapon("Hook", "Drowned Hook is A rusty hook used for fishing, now a deadly weapon for close combat.", 5, "\uD83D\uDD29");
        Weapon ghostlyCrossbow = new RangedWeapon("Crossbow", "Ghostly Crossbow is A spectral crossbow that fires bolts imbued with the essence of the dead.", 20, 6, "\uD83C\uDFF9");
        room3.addItems(drownedHook);
        room3.addItems(ghostlyCrossbow);

        //Food
        Item herbalTea = new Food("Tea", "Herbal Tea is A soothing tea brewed from forest herbs - health +15", 15, "\uD83C\uDF75");
        Item spoiledFruit = new Food("Fruit", "Spoiled Fruit is A piece of fruit that has gone bad - health -10", -10, "\uD83C\uDF4E");
        room3.addItems(herbalTea);
        room3.addItems(spoiledFruit);

        //Enemies
        Weapon chain = new MeleeWeapon("Chain", "A heavy, dripping chain that pulls enemies into the deep.",25,"\\u26D3");
        Enemy drownedSpecter = new Enemy("DrownedSpecter","The restless spirit of one who drowned in the creek, its hollow eyes fixed on you.",50,this,chain);
        room3.addEnemy(drownedSpecter);
        Weapon murkTentacle = new MeleeWeapon("Tentacle", "A slimy appendage that smothers and constricts its target.", 35, "\\uD83E\\uDD91");
        Enemy murkwraith = new Enemy("Murkwraith", "A malevolent entity born from the swamp's filth, moving silently in the muck.", 55, this, murkTentacle);
        room3.addEnemy(murkwraith);


        //Room 4
        Room room4 = new Room("The Twisted Path ", "This winding trail seems endless. The trees here are unnaturally twisted, their branches like claws reaching toward you. ", "2 exits ");
        Food redBull = new Food("Redbull", "Might be good, might be bad, drink if you dare...", 10, "⚡");
        room4.addItems(redBull);

        //Weapons
        Weapon cursedWhip = new MeleeWeapon("Whip", "The Cursed Whip is A whip made of twisted vines, it strikes fear and pain into its targets.", 15, "\uD83C\uDF3F");
        Weapon thornedSlingshot = new RangedWeapon("Slingshot", "The Thorned Slingshot A slingshot crafted from thorny branches, fires sharp seeds.", 10, 6, "\uD83D\uDD29");
        room4.addItems(cursedWhip);
        room4.addItems(thornedSlingshot);

        //Food
        Item foragedRoots = new Food("Roots", "Foraged Roots gathered from the forest floor - health +5", 5, "\uD83C\uDF3D");
        Item rottenVegetable = new Food("Vegetable", "Rotten Vegetable is A vegetable that has started to decay - health -7", -7, "\uD83C\uDF3F");
        room4.addItems(foragedRoots);
        room4.addItems(rottenVegetable);

        //Enemies
        Weapon whip = new MeleeWeapon("Whip", "A living whip of thorny vines that lashes out with deadly accuracy.", 30, "\\uD83C\\uDF33");
        Enemy entangledHorror = new Enemy("EntangledHorror", "A monstrous form woven from the cursed vines of the forest, ensnaring all who pass.", 60, this, whip);
        room4.addEnemy(entangledHorror);

        Weapon shadowDagger = new MeleeWeapon("Dagger", "A dagger made of shadow, stabbing silently from the darkness.", 40, "\\uD83D\\uDDE1");
        Enemy forestPhantom = new Enemy("ForestPhantom", "A shadowy figure that appears from the underbrush, striking swiftly then vanishing.", 65, this, shadowDagger);
        room4.addEnemy(forestPhantom);

        //Room 5
        Room room5 = new Room("Drakthor's Lair ", "The final room where the mighty dragon awaits. Lava flows beneath jagged rocks, and the heat is suffocating.\nDefeat Drakthor to bring peace to the land. ", " ");

        //Final BOOOSS!!
        MeleeWeapon drakthorBreath = new MeleeWeapon("Breath", "A blast of molten fire, capable of incinerating anything in its path.", 90, "\\uD83D\\uDD25");
        Enemy drakthor = new Enemy("Drakthor", "Drakthor The Devourer is the ultimate foe, a massive dragon with scales like molten rock and a heart full of hatred.", 100, this, drakthorBreath);
        room5.addEnemy(drakthor);


        //Room 6
        Room room6 = new Room("Cursed Grove ", "The trees here seem alive, and their branches move as if trying to grab you.\nThis area is filled with cursed creatures drawn to the dark magic. ", " ");


        //Weapons
        Weapon witchesBroom = new MeleeWeapon("Broom", "The Witches Broom is A broom used by the forest witch, capable of striking from afar.", 25, "\uD83E\uDDF8");
        Weapon hauntedSling = new RangedWeapon("Sling", "The Haunted Sling is A slingshot that fires cursed pebbles, causing minor damage.", 10, 6, "\uD83D\uDD29");
        room6.addItems(witchesBroom);
        room6.addItems(hauntedSling);

        //Food
        Item enchantedFruit = new Food("Fruit", "Enchanced Fruit is A fruit that grants a brief surge of energy - health +20", 20, "\uD83C\uDF4C");
        Item sugarCane = new Food("Cane", "Sugar Cane is A sweet treat that provides energy but can be harmful - health -5", -5, "\uD83C\uDF6C");
        room6.addItems(enchantedFruit);
        room6.addItems(sugarCane);

        //Enemies
        Weapon cursedScythe = new MeleeWeapon("Scythe", "A wicked scythe that drains the life force of its victims.", 50, "\\u26C2");
        Enemy cursedReaper = new Enemy("CursedReaper", "A shadowy figure with a scythe, it revels in the suffering of the living.", 75, this, cursedScythe);
        room6.addEnemy(cursedReaper);

        Weapon fist = new MeleeWeapon("Fist", "Massive fists of wood that crush anything they touch.", 40, "\\uD83C\\uDF32");
        Enemy possessedTree = new Enemy("PossessedTree", "A towering tree, its twisted roots and branches moving with sinister intent.", 70, this, fist);
        room6.addEnemy(possessedTree);

        Weapon voodooStaff = new MeleeWeapon("Staff", "A magical staff that curses and weakens foes.", 50, "\\uD83E\\uDDE9");
        Enemy voodooWitch = new Enemy("VoodooWitch", "An old crone who manipulates the forest’s dark magic for her wicked schemes.", 75, this, voodooStaff);
        room6.addEnemy(voodooWitch);

        //Room 7
        Room room7 = new Room("The Webbed Hollow ", "Thick webs hang between the trees, and giant spiders lurk here.\nThe sound of skittering legs fills the air as they hunt. ", " ");


        //Weapons
        Weapon webSling = new RangedWeapon("Sling", "The Web Sling A slingshot made of spider silk, it fires sticky projectiles.", 20, 6, "\uD83D\uDC1B");
        Weapon giantSpiderFang = new MeleeWeapon("Fang", "The Giant Spider Fang is A fang of a giant spider, deadly in melee combat.", 45, "\uD83D\uDC1B");
        room7.addItems(webSling);
        room7.addItems(giantSpiderFang);

        //Food
        Item honeycomb = new Food("Honeycomb", "A sweet treat filled with energy - health +15", 15, "\uD83C\uDF6F");
        Item moldyBread = new Food("Bread", "Moldy Bread covered in mold, best to avoid - health -10", -10, "\uD83C\uDF5E");
        room7.addItems(honeycomb);
        room7.addItems(moldyBread);

        //Enemies
        Weapon fang = new MeleeWeapon("Fang", "Deadly fangs dripping with paralytic venom.", 50, "\\uD83D\\uDC1B");
        Enemy widowWeaver = new Enemy("WidowWeaver", "A giant spider lurking in the shadows, spinning webs to trap its prey.", 80, this, fang);
        room7.addEnemy(widowWeaver);

        Weapon web = new MeleeWeapon("Web", "Sticky webs that bind and immobilize enemies.", 20, "\\uD83D\\uDD78");
        Enemy skitteringBrood = new Enemy("Skittering Brood", "A swarm of smaller spiders, fast and deadly, attacking from all directions.", 65, this, web);
        room7.addEnemy(skitteringBrood);

        Weapon webArcherBow = new RangedWeapon("Crossbow", "A crossbow that fires poisoned bolts.", 30, 6, "\\uD83D\\uDDE1");
        Enemy webArcher = new Enemy("WebArcher", "A spider-like creature that shoots venomous projectiles from its lair.", 70, this, webArcherBow);
        room7.addEnemy(webArcher);

        //Room 8
        Room room8 = new Room("Shattered Ruins", "Old stone structures stand crumbling in this part of the forest.\nOnce part of an ancient civilization, these ruins are now home to dark forces. ", " ");

        //Weapons
        Weapon ancientSword = new MeleeWeapon("Sword", "The Ancient Sword is A sword buried in the ruins, its blade is etched with ancient runes.", 60, "\u2694");
        Weapon stoneThrower = new RangedWeapon("Thrower", "The Stone Thrower is A simple slingshot that launches small rocks at enemies.", 5, 6, "\uD83D\uDDA4");
        room8.addItems(ancientSword);
        room8.addItems(stoneThrower);

        //Food
        Item mushroomSoup = new Food("Soup", "Mushroom Soup is A hearty soup made from forest mushrooms - health +25", 25, "\uD83E\uDDF5");
        Item greasyStew = new Food("Stew", "Greasy Stew is A thick stew that leaves a heavy feeling - health -15", -15, "\uD83C\uDF72");
        room8.addItems(mushroomSoup);
        room8.addItems(greasyStew);

        //Enemies
        Weapon stoneFist = new MeleeWeapon("Fist", "Massive stone fists that crush anything they touch.", 60, "\\uD83E\\uDEA8");
        Enemy stoneGolem = new Enemy("StoneGolem", "A massive, hulking creature made entirely of stone, moving with earth-shaking steps.", 85, this, stoneFist);
        room8.addEnemy(stoneGolem);

        Weapon arcaneStaff = new MeleeWeapon("Staff", "A magical staff that radiates arcane energy.", 70, "\\u26A1");
        Enemy arcaneSentinel = new Enemy("ArcaneSentinel", "An ancient magical guardian, radiating arcane energy as it protects the ruins.", 90, this, arcaneStaff);
        room8.addEnemy(arcaneSentinel);

        Weapon ruinBow = new RangedWeapon("Bow", "An ethereal bow that fires energy arrows.", 40, 6, "\\uD83C\\uDFF9");
        Enemy ruinMarksman = new Enemy("RuinMarksman", "A spectral archer bound to the ruins, shooting arrows of pure energy.", 80, this, ruinBow);
        room8.addEnemy(ruinMarksman);

        //Room 9
        Room room9 = new Room("Graveyard Of Heroes -", "Tombstones and broken statues line this part of the forest.\nThe spirits of fallen warriors haunt this place, seeking revenge for their unfinished quests. ", " ");

        //Weapons
        Weapon herosAxe = new MeleeWeapon("Axe", "The Heros Axe is an ancient axe once wielded by a legendary hero, it radiates power.", 75, "\uD83D\uDDE1");
        Weapon ghostlyBow = new RangedWeapon("Bow", "The Ghostly Bow is a bow that shoots arrows made of pure spirit energy, piercing through the veil.", 65, 6, "\uD83C\uDFF9");
        room9.addItems(herosAxe);
        room9.addItems(ghostlyBow);

        //Food
        Item apple = new Food("Apple", "Is a radiant apple that grants a burst of energy, invigorating the spirit - health +15", 15, "\uD83C\uDF4F");
        room9.addItems(apple);
        Item herosFeast = new Food("Feast", "Heros Feast is A legendary meal said to restore one's spirit - health +50", 50, "\uD83C\uDF7E");
        Item spoiledRations = new Food("Rations", "Spoiled Rations is Old rations that should be discarded - health -15", -15, "\uD83C\uDF5D");
        room9.addItems(herosFeast);
        room9.addItems(spoiledRations);

        //Enemies
        Weapon knightSword = new MeleeWeapon("KnightSword", "A blade that steals the life force of those it cuts.", 70, "\\u2694");
        Enemy revenantKnight = new Enemy("RevenantKnight", "The restless soul of a fallen knight, still seeking glory even in death.", 85, this, knightSword);
        room9.addEnemy(revenantKnight);

        Weapon scythe = new MeleeWeapon("Scythe", "A scythe that reaps the souls of the fallen, growing stronger with each kill.", 80, "\\u2620");
        Enemy boneReaper = new Enemy("BoneReaper", "A skeletal reaper who harvests the souls of the dead with every swing.", 90, this, scythe);
        room9.addEnemy(boneReaper);



        //Room 1 muligheder
        room1.setModeast(room2);
        room1.setModsouth(room4);

        //Room 2 muligheder
        room2.setModwest(room1);
        room2.setModeast(room3);

        //Room 3 muligheder
        room3.setModwest(room2);
        room3.setModsouth(room6);

        //Room 4 muligheder
        room4.setModnorth(room1);
        room4.setModsouth(room7);

        //Room 5 muligheder
        room5.setModsouth(room8);

        //Room 6 muligheder
        room6.setModnorth(room3);
        room6.setModsouth(room9);

        //Room 7 muligheder
        room7.setModnorth(room4);
        room7.setModeast(room8);

        //Room 8 muligheder
        room8.setModwest(room7);
        room8.setModeast(room9);
        room8.setModnorth(room5);

        //Room 9 muligheder
        room9.setModwest(room8);
        room9.setModnorth(room6);

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        if (currentRoom == null) {
            System.out.println("Dette rum er null");

        }
        return this.currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

}
