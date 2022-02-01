package nextstep.subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("구간 단위 테스트(Section)")
class SectionTest {

    private Station upStation;
    private Station downStation;
    private int distance;

    @BeforeEach
    void setUp() {
        upStation = new Station("upStation");
        downStation = new Station("downStation");
        distance = 10;
    }

    @DisplayName("특정 역을 소유하고 있는지 반환")
    @Test
    void hasAnyStation() {
        // given
        final Station extraStation = new Station("extraStation");
        final Section section = new Section(new Line("color", "name"), upStation, downStation, distance);

        // when
        boolean upStationExpected = section.hasAnyStation(upStation);
        boolean downStationExpected = section.hasAnyStation(downStation);
        boolean extraStationExpected = section.hasAnyStation(extraStation);

        // then
        assertAll(
                () -> assertThat(upStationExpected).isTrue(),
                () -> assertThat(downStationExpected).isTrue(),
                () -> assertThat(extraStationExpected).isFalse()
        );
    }

    @DisplayName("특정 역이 상행선으로 등록되었는지 반환")
    @Test
    void hasUpStation() {
        // given
        final Section section = new Section(new Line("color", "name"), upStation, downStation, distance);

        // when
        boolean upStationExpected = section.hasUpStation(upStation);
        boolean downStationExpected = section.hasUpStation(downStation);

        // then
        assertAll(
                () -> assertThat(upStationExpected).isTrue(),
                () -> assertThat(downStationExpected).isFalse()
        );
    }

    @DisplayName("특정 역이 하행선으로 등록되었는지 반환")
    @Test
    void hasDownStation() {
        // given
        final Section section = new Section(new Line("color", "name"), upStation, downStation, distance);

        // when
        boolean upStationExpected = section.hasDownStation(upStation);
        boolean downStationExpected = section.hasDownStation(downStation);

        // then
        assertAll(
                () -> assertThat(upStationExpected).isFalse(),
                () -> assertThat(downStationExpected).isTrue()
        );
    }
}
