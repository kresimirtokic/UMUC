/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kresimir.tokic
 */

import java.util.ArrayList;

public class StatesData {

    ArrayList<String> allStateData = new ArrayList<>();
    
    static String[] stateNames = new String[]{"Alabama", "Alaska", "Arizona", "Arkansas", "California",
        "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
        "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
        "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
        "Nevada", "New Hampshire", "New Jersey", "NewMexico", "NewYork",
        "North Carolina", "NorthDakota", "Ohio", "Oklahoma", "Oregon",
        "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
        "West Virginia", "Wisconsin", "Wyoming"};
    static String[] stateFlower = new String[]{"Camellia", "Forget-me-not", "Saguaro Cactus Blossom", "Apple Blossom",
        "California Poppy", "RockyMounting Columbine", "Mountain Laurel",
        "Peach Blossom", "Orange Blossom", "Cheokee Rose", "Hibiscus",
        "Mock Orange", "Purple Violet", "Peony", "Wild Prarie Rose", "Sunflower",
        "Goldenrod", "Magnolia", "White Pine Tassel", "Black-eyed Susan", "Mayflower",
        "Apple Blossom", "Pink White Ladyslipper", "Magnolia", "Hawthorn", "Bitterroot",
        "Goldenrod", "Sagebrush", "Purple Lilac", "Violet", "Yucca", "Rose",
        "Flowering Dogwood", "Wild Prarie Rose", "Scarelet Carnation", "Mistletoe",
        "Oregon Grape", "Mountain Laurel", "Violet", "Yellow Jessamine", "Pasque Flower",
        "Iris", "Bluebonnet", "Sego Lily", "Red Clover", "Flowering Dogwood",
        "Coast Rhododendron", "Rhododendron", "Violet", "Indian Paintbrush"};
    static String[] stateBird = new String[]{"Yellow Hammer", "Willow ptarmigan", "Cactus Wren",
        "Northern Mockingbird", "California Quail", "Lark Bunting", "American Robin",
        "Delaware Blue Hen", "Northern Mockingbird", "Brown Thrasher", "Hawaiian Goose",
        "Mountain Bluebird", "Northern Cardinal", "Northern Cardinal", "Eastern Goldfinch", "Western Meadowlark",
        "Northern Cardinal", "Brown Pelican", "Black-capped Chickadee", "Baltiomre Oriole",
        "Black-capped Chickadee", "American Robin", "Common Loon", "Northern Mockingbird",
        "Eastern Bluebird", "Western Meadowlark", "Western Meadowlark", "Mountain Bluebird",
        "Purlple Finch", "Eastern Goldfinch", "Roadrunner", "Eastern Bluebird",
        "Northern Cardinal", "Western Meadowlark", "Northern Cardinal", "Scissor-tailed flycatcher",
        "Western Meadowlardk", "Rufffed Grouse", "Rhode Island Red", "Carolina Wren",
        "Ring-necked Pheasant", "Northern Mockingbird", "Northern Mockingbird",
        "California Gull", "Hermit Thrush", "Northern Cardinal", "Willow Goldfinch",
        "Northern Cardinal", "American Robin", "Western Meadowlark"};

    /*
    static String[][] allData = new String[][] {{"Alabama", "Camellia", "Yellow Hammer"},
            {"Alaska", "Forget-me-not", "Willow Pratmigan"},
            {"Arizona", "Saguaro Cactus Blossom", "Cactus Wren"},
            {"Arkansas", "Apple Blossom", "Northern Mockingbird"}
        };
     */
    //get methods for state,flower, bird
    public String[] getStateNames(int indexPosition) {
        return this.stateNames;
    }

    public String[] getStateFlowers(int indexPosition) {
        return this.stateFlower;
    }

    public String[] getStateBirds(int indexPosition) {
        return this.stateBird;
    }

    public String[] getAllData(int indexPosition) {
        return this.allData;
    }

    //setter methods for state, flower, bird
    public String[] setStateName() {
        return this.stateNames;
    }

    public String[] setStateFlower() {
        return this.stateFlower;
    }

    public String[] setStateBird() {
        return this.stateBird;
    }

//constructor
    public ArrayList<String> buildStateData(int indexPosition) {
        return allStateData.add(stateNames[indexPosition]); //, stateBird[indexPosition], stateFlower[indexPosition]);
    } 
}//end class
