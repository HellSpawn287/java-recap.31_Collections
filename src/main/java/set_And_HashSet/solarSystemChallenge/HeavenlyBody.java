package set_And_HashSet.solarSystemChallenge;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, BodyType bodyType, double orbitalPeriod) {
        this.key = createKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public static Key createKey(String name, BodyType bodyType) {
        return new Key(name, bodyType);
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyType.STAR) {
            return false;
        }
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return satellites;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HeavenlyBody) {
            HeavenlyBody that = (HeavenlyBody) o;
            return this.key.equals(that.getKey());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return "name: '" + this.key.name + '\'' +
                ", " + this.key.bodyType +
                ", " + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyType bodyType;

        public Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Key key = (Key) o;
            if (name.equals(key.name)) {
                return this.bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, bodyType) + 57;
        }

        @Override
        public String toString() {
            return this.name + ": "+ this.bodyType;
        }
    }
}
