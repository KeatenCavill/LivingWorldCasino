package npcs;
import core.NPC;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import core.Player;

public class Singer extends NPC {
    
    private String genre;
    private List<String> setlist;
    private String song;
    private double skill;
    private double earnings;

    public Singer(){
        try {
            List<String> lines = Files.readAllLines(Path.of("singer_songs/genres.txt"));
            this.genre = lines.get(new Random().nextInt(lines.size()));
            switch(this.genre){
                case "Bluegrass": this.setlist = Files.readAllLines(Path.of("singer_songs/bluegrass_songs.txt"));
                case "Country": this.setlist = Files.readAllLines(Path.of("singer_songs/country_songs.txt"));
                case "Country Rock": this.setlist = Files.readAllLines(Path.of("singer_songs/countryrock_songs.txt"));
                case "Classic Rock": this.setlist = Files.readAllLines(Path.of("singer_songs/classicrock_songs.txt"));
                case "Alt Rock": this.setlist = Files.readAllLines(Path.of("singer_songs/altrock_songs.txt"));
                case "Jazz": this.setlist = Files.readAllLines(Path.of("singer_songs/jazz_songs.txt"));
                case "2000's Pop": this.setlist = Files.readAllLines(Path.of("singer_songs/2000spop_songs.txt"));
                case "Midwest Emo": this.setlist = Files.readAllLines(Path.of("singer_songs/midwestemo_songs.txt"));
            }
        } 
        catch(Exception err) {err.printStackTrace();}

        this.song = this.setlist.get((int)(Math.random() * setlist.size()));
        this.skill = Math.random();


    }

    public String getSong(){System.out.println(super.name + "is now playing " + this.song); return(this.song);}
    public String changeSong(){
        this.song = this.setlist.get((int)(Math.random() * setlist.size()));
        System.out.println(super.name + "is now playing " + this.song);
        return(this.song);
    }
    public void requestSong(String SongOP){
        if(this.earnings < 10 || Math.random() > 0.9){
            changeSong();
            System.out.println(super.name + " starts singing " + this.song + " and completely ignores you.");
        } else {
            this.setlist.add(SongOP);
            this.song = SongOP;
            System.out.println(super.name + " starts singing " + SongOP + ". The song you requested!");
        }
    }

    public double getSkill(){
        if(this.skill < 0.25){
            System.out.println("Well, " + super.name + " is definitely singing...");
        } else if(this.skill > 0.8){
            System.out.println(super.name + " sounds so beautiful, it brings a tear to your eye.");
        } else {
            System.out.println(super.name + " doesn't sound half bad!");
        }
        return(this.skill);
    }

    public void tip(double tip){
        this.earnings = this.earnings + tip;
        this.skill = this.skill + (tip / 100);
        if(this.skill > 1){
            this.skill = 1;
        }
        System.out.println(super.name + " gives you a smile and starts singing with a little more emotion.");
    }

    public void steal(Player player){
        double theftAmount = Math.random() * this.earnings;
        if(theftAmount == 0){
            System.out.println(super.name + " didn't have any money for you to steal!");
        } else if(super.getStealDifficulty() < Math.random()){
            System.out.println("You shove your hand into " + super.name + "'s tip jar when they aren't looking and make out with $" + theftAmount + ".");
            System.out.println("Shame on you!");
        } else {
            System.out.println(super.name + " never looked away long enough for you to snatch anything. They were staring right. At you.");
        }
    }

}
