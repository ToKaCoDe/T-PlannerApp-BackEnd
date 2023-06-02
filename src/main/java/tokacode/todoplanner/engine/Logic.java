package tokacode.todoplanner.engine;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import tokacode.todoplanner.model.BusyDate;
import tokacode.todoplanner.model.FreeDate;

public class Logic {

	public LocalDate startdate;
	public Integer scope;
	public LocalDate deadline;

	int hours;
	int freeHoursTotal;

	public List<LocalDate> celebrationDays = new ArrayList<>();
	public List<BusyDate> busyDays = new ArrayList<>();
	public List<FreeDate> freeDays = new ArrayList<>();

// ---------------------------------------------------------
	public List<FreeDate> getFreeDates(LocalDate start, LocalDate end) {

		int dayTime = 24;
		int sleepTime = 8;
		int workTime = 8;
		int eatTimePerDay = 2;
		int freeTime = 0;
		celebrationDays = getHolidayDates(startdate, deadline);

		LocalDate date = start;

		while (!date.isAfter(end)) {
			DayOfWeek dayOfWeek = date.getDayOfWeek();

			if (celebrationDays.contains(date)) {
				freeTime = 0;
			} else if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
				freeTime = dayTime - sleepTime - eatTimePerDay - getBusyHours(date);
			} else {
				freeTime = dayTime - sleepTime - workTime - eatTimePerDay - getBusyHours(date);
			}

			if (freeTime > 0) {
				FreeDate fdays = new FreeDate(date, freeTime);
				freeDays.add(fdays);
				freeHoursTotal = freeHoursTotal + freeTime;
			}

			date = date.plusDays(1);
		}

		return freeDays;
	}

//----------------------------------
	public int getBusyHours(LocalDate date) {

		for (BusyDate days : busyDays) {
			LocalDate day = days.getBusydate();
			if (day.equals(date)) {
				hours = days.getBusyhours();
			}
		}

		return hours;
	}

//------------------------------------
	public List<LocalDate> getHolidayDates(LocalDate start, LocalDate end) {

		List<LocalDate> celebrations = new ArrayList<>();
		String celebrationDays[][] = { { "01", "01" }, { "02", "16" }, { "03", "11" }, { "04", "01" }, { "05", "01" },
				{ "06", "24" }, { "07", "06" }, { "08", "15" }, { "11", "01" }, { "11", "02" }, { "12", "24" },
				{ "12", "25" }, { "12", "26" } };
		int startYear = start.getYear();
		int endYear = end.getYear();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		while (startYear <= endYear) {
			for (int i = 0; i < celebrationDays.length; i++) {
				String celdate = startYear + "-" + celebrationDays[i][0] + "-" + celebrationDays[i][1];
				LocalDate date = LocalDate.parse(celdate, formatter);
				celebrations.add(date);
			}
			startYear++;
		}

		return celebrations;
	}

	public long getDaysDiff() {
		return ChronoUnit.DAYS.between(startdate, deadline) + 1;
	}

// ------------------------------------------------------------

	public String isTaskDone() {

		String answer;

		if (scope <= freeHoursTotal) {
			answer = "DO IT !!! - there is enough time.";
		} else {
			answer = "Sorry, NOT enough time!!!";
		}

		return answer;
	}

//-------------------------------------------------------
	public Long getAverageHours() {

		long needHours = scope / getFreeDates(startdate, deadline).size();

		return needHours;
	}

}
