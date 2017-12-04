.class public Lcom/example/huixing/iforcerebuild/RGBColor;
.super Ljava/lang/Object;
.source "RGBColor.java"


# instance fields
.field private m_Blue:I

.field private m_Green:I

.field private m_Red:I


# direct methods
.method public constructor <init>(III)V
    .registers 5
    .param p1, "paramInt1"    # I
    .param p2, "paramInt2"    # I
    .param p3, "paramInt3"    # I

    .prologue
    const/4 v0, 0x0

    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput v0, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Blue:I

    .line 10
    iput v0, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Green:I

    .line 11
    iput v0, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Red:I

    .line 15
    invoke-virtual {p0, p1, p2, p3}, Lcom/example/huixing/iforcerebuild/RGBColor;->setColor(III)V

    .line 16
    return-void
.end method


# virtual methods
.method public getB()I
    .registers 2

    .prologue
    .line 20
    iget v0, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Blue:I

    return v0
.end method

.method public getG()I
    .registers 2

    .prologue
    .line 25
    iget v0, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Green:I

    return v0
.end method

.method public getR()I
    .registers 2

    .prologue
    .line 30
    iget v0, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Red:I

    return v0
.end method

.method public setColor(III)V
    .registers 4
    .param p1, "paramInt1"    # I
    .param p2, "paramInt2"    # I
    .param p3, "paramInt3"    # I

    .prologue
    .line 35
    iput p1, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Red:I

    .line 36
    iput p2, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Green:I

    .line 37
    iput p3, p0, Lcom/example/huixing/iforcerebuild/RGBColor;->m_Blue:I

    .line 38
    return-void
.end method
