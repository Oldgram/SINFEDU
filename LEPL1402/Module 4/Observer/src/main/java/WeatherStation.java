public class WeatherStation extends Observable{

    /*
     * Returns an array containing all the observers of the station
     */
    @Override
    public Observer[] getSubscribers() {
        Observer[] obs = new Observer[subscribers.size()];
        for (int i = 0; i < obs.length; i++) {
            obs[i] = subscribers.get(i);
        }
        return obs;
    }

    /*
     * Sends a message to APPROPRIATE subscribers.
     */
    @Override
    public void broadcast(Pair<String, Integer> pair) {
        Observer[] obs = getSubscribers();
        for (Observer o : obs) {
            if (o.getZone() == pair.getZone()) {
                o.update(pair.getAlert());
            }
        }
    }

    /*
     * Adds an observer to the subscribers of the station
     */
    @Override
    public void addObserver(Observer sub) {
        if (!subscribers.contains(sub)) {
            subscribers.add(sub);
        }
    }

    /*
     * Removes an observer from the subscribers of the station
     */
    @Override
    public boolean removeObserver(Observer sub) {
        return subscribers.removeIf(o -> o == sub);
    }

    /*
     * Sets the current alert for a given zone. Note that
     * there must be AT MOST one alert for each zone and
     * when an alert is set, subscribers of the zone must
     * receive a message
     */
    @Override
    public void setAlert(String alert, int zone) {
        Observer[] obs = getSubscribers();
        for (Observer o : obs) {
            if (o.getZone() == zone) {
                o.update(alert);
            }
        }
    }
}
