import java.lang.Math;

public class HpUp extends PokemonDecorator{
    public HpUp(Pokemon p){
        super(p,"+HP",(int) (Math.random() + 1));
        /*Pokemon newPokemon;
        int randHp = (int) (Math.random() + 1);
        int randMaxHp = (int) (Math.random() + 1);
        
        switch (p.getType()){
            case 0:
                newPokemon = new Fire(p.getName()+"+HP", p.getHp() + randHp, p.getMaxHp() + randMaxHp);
            case 1:
                newPokemon = new Water(p.getName()+"+HP", p.getHp() + randHp, p.getMaxHp() + randMaxHp);
            case 2:
                newPokemon = new Grass(p.getName()+"+HP", p.getHp() + randHp, p.getMaxHp() + randMaxHp);
        }*/
        
    }
}