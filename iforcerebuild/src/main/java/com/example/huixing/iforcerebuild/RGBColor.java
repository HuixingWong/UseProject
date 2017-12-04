package com.example.huixing.iforcerebuild;

/**
 * Created by huixing on 2017/10/9.
 */

public class RGBColor
{
    private int m_Blue = 0;
    private int m_Green = 0;
    private int m_Red = 0;

    public RGBColor(int paramInt1, int paramInt2, int paramInt3)
    {
        setColor(paramInt1, paramInt2, paramInt3);
    }

    public int getB()
    {
        return this.m_Blue;
    }

    public int getG()
    {
        return this.m_Green;
    }

    public int getR()
    {
        return this.m_Red;
    }

    public void setColor(int paramInt1, int paramInt2, int paramInt3)
    {
        this.m_Red = paramInt1;
        this.m_Green = paramInt2;
        this.m_Blue = paramInt3;
    }
}