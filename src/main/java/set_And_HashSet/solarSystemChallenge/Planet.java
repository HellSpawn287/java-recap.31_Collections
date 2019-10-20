package set_And_HashSet.solarSystemChallenge;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, BodyType.PLANET, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyType.MOON){
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
