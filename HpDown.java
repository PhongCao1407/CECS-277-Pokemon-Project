public class HpDown extends PokemonDecorator{
    public HpDown(Pokemon p){
        super(p,"-HP",-1);
        /*Pokemon newPokemon;
        switch (p.getType()){
            case 0:
                newPokemon = new Fire(p.getName()+"-HP", p.getHp() - 1, p.getMaxHp() - 1);
            case 1:
                newPokemon = new Water(p.getName()+"-HP", p.getHp() - 1, p.getMaxHp() - 1);
            case 2:
                newPokemon = new Grass(p.getName()+"-HP", p.getHp() - 1, p.getMaxHp() - 1);
        }*/
    }
}