package tomaszmorgas.financemanager.entity;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class DateRange {
    @NotNull(message="wypełnij date")
    private Date startDate;
    @NotNull(message="wypełnij date")
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
