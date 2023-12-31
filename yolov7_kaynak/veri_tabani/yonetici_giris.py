# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'form.ui'
#
# Created by: PyQt5 UI code generator 5.15.9
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets
import os
import sqlite3 as sql
db = sql.connect("db.sqlite")
imlec = db.cursor()

class Ui_yonetici_islem(object):
    def setupUi(self, yonetici_islem):
        yonetici_islem.setObjectName("yonetici_islem")
        yonetici_islem.resize(800, 600)
        yonetici_islem.setMinimumSize(QtCore.QSize(800, 600))
        yonetici_islem.setMaximumSize(QtCore.QSize(800, 600))
        self.yonetici_Giris = QtWidgets.QPushButton(yonetici_islem)
        self.yonetici_Giris.setGeometry(QtCore.QRect(340, 460, 88, 27))
        self.yonetici_Giris.setObjectName("yonetici_Giris")
        self.label = QtWidgets.QLabel(yonetici_islem)
        self.label.setGeometry(QtCore.QRect(250, 130, 251, 81))
        font = QtGui.QFont()
        font.setPointSize(30)
        font.setBold(True)
        font.setWeight(75)
        self.label.setFont(font)
        self.label.setObjectName("label")
        self.yonetici_adi = QtWidgets.QLineEdit(yonetici_islem)
        self.yonetici_adi.setGeometry(QtCore.QRect(220, 290, 331, 27))
        self.yonetici_adi.setObjectName("yonetici_adi")
        self.yonetici_sifre = QtWidgets.QLineEdit(yonetici_islem)
        self.yonetici_sifre.setGeometry(QtCore.QRect(220, 360, 331, 27))
        self.yonetici_sifre.setObjectName("yonetici_sifre")
        self.label_2 = QtWidgets.QLabel(yonetici_islem)
        self.label_2.setGeometry(QtCore.QRect(220, 260, 151, 19))
        self.label_2.setObjectName("label_2")
        self.label_3 = QtWidgets.QLabel(yonetici_islem)
        self.label_3.setGeometry(QtCore.QRect(220, 330, 67, 19))
        self.label_3.setObjectName("label_3")

        self.retranslateUi(yonetici_islem)
        QtCore.QMetaObject.connectSlotsByName(yonetici_islem)

    def retranslateUi(self, yonetici_islem):
        _translate = QtCore.QCoreApplication.translate
        yonetici_islem.setWindowTitle(_translate("yonetici_islem", "Yonetici Giris"))
        self.yonetici_Giris.setText(_translate("yonetici_islem", "Giriş Yap"))
        self.label.setText(_translate("yonetici_islem", "Yönetici Girişi"))
        self.label_2.setText(_translate("yonetici_islem", "Kullanıcı Adı"))
        self.label_3.setText(_translate("yonetici_islem", "Şifre"))

        self.yonetici_Giris.clicked.connect(self.Giris_fonksiyon)
    
    def Giris_fonksiyon(self):
        if str(self.yonetici_adi.text()) == "admin" and str(self.yonetici_sifre.text()) == "admin":
            os.system("python3 yonetici_ana_menu.py")
            


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    yonetici_islem = QtWidgets.QWidget()
    ui = Ui_yonetici_islem()
    ui.setupUi(yonetici_islem)
    yonetici_islem.show()
    sys.exit(app.exec_())
