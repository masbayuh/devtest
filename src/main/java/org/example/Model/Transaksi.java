package org.example.Model;

import java.util.Date;

public class Transaksi {
    private Integer idReport, tagihanReport, adminFeeReport;
    private String codeClientReport, codeReport, statusReport;
    private Date tanggalReport;

    public Integer getIdReport() {
        return idReport;
    }

    public void setIdReport(Integer idReport) {
        this.idReport = idReport;
    }

    public Integer getTagihanReport() {
        return tagihanReport;
    }

    public void setTagihanReport(Integer tagihanReport) {
        this.tagihanReport = tagihanReport;
    }

    public Integer getAdminFeeReport() {
        return adminFeeReport;
    }

    public void setAdminFeeReport(Integer adminFeeReport) {
        this.adminFeeReport = adminFeeReport;
    }

    public String getCodeClientReport() {
        return codeClientReport;
    }

    public void setCodeClientReport(String codeClientReport) {
        this.codeClientReport = codeClientReport;
    }

    public String getCodeReport() {
        return codeReport;
    }

    public void setCodeReport(String codeReport) {
        this.codeReport = codeReport;
    }

    public String getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(String statusReport) {
        this.statusReport = statusReport;
    }

    public Date getTanggalReport() {
        return tanggalReport;
    }

    public void setTanggalReport(Date tanggalReport) {
        this.tanggalReport = tanggalReport;
    }
}
