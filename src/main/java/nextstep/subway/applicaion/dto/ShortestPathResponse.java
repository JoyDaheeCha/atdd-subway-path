package nextstep.subway.applicaion.dto;

import nextstep.subway.domain.Station;

import java.util.List;

public class ShortestPathResponse {

	private List<Station> stations;

	private int distance;

	public ShortestPathResponse(List<Station> stations, int distance) {
		this.stations = stations;
		this.distance = distance;
	}

	public List<Station> getStations() {
		return stations;
	}

	public int getDistance() {
		return distance;
	}
}
