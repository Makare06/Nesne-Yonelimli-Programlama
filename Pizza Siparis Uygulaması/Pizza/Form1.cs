using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.RegularExpressions;
namespace Pizza
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

        }
      
        private void buttonTemizle_Click(object sender, EventArgs e)
        {   
          
           
        }
          private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void buttonSiparisAl_Click(object sender, EventArgs e)
        {  //ucret ve ekstra adında değişkenler tanımlıyoruz
            decimal ucret = 0;
            string ekstra = "";
           
            //Eğer checkbox'lar seçili ise ekstra değişkenine aktarılıyor.
            if (checkBoxSucuk.Checked == true)
            { ekstra += "Sucuk";}
            if (checkBoxSosis.Checked == true)
            { ekstra += " - " + "Sosis";}
            if (checkBoxMantar.Checked == true)
            { ekstra += " - " + "Mantar" ; }
            if (checkBoxKasar.Checked == true)
            { ekstra += " - " + "Kaşar" ; } 
            if (checkBoxPeynir.Checked == true)
            { ekstra += " - " + "Peynir" ; }
            if (checkBoxSebze.Checked == true)
            { ekstra += " - " + "Sebze" ; }
            

            //Seçili olan değeri ucret değişkenine adet bilgisi ile çarparak ekliyoruz.
            if (comboBoxPizzaBoy.Text =="Küçük")
            {ucret = numericUpDownPizza.Value * 10;}
            else if (comboBoxPizzaBoy.Text == "Orta")
            {ucret = numericUpDownPizza.Value * 15;}
            else if (comboBoxPizzaBoy.Text == "Büyük")
            {ucret = numericUpDownPizza.Value * 20;}


            if(comboBoxIcecek.Text=="2,5lt Coca Cola")
            {ucret += numericUpDownIcecek.Value * 5;}
            else if(comboBoxIcecek.Text=="1lt Fanta")
            {ucret += numericUpDownIcecek.Value * 3;}
            else if (comboBoxIcecek.Text == "1lt Sprite")
            {ucret += numericUpDownIcecek.Value * 3;}
            

            //Listbox'a değerleri yazdırıyoruz.
            listBoxAdSoyad.Items.Add(textBoxAdSoyad.Text);
            listBoxTelefon.Items.Add(textBoxTelefon.Text);
            listBoxAdres.Items.Add(textBoxAdres.Text);
            listBoxPizza.Items.Add(numericUpDownPizza.Value + " adet " + comboBoxPizzaBoy.Text);
            listBoxIcecek.Items.Add(numericUpDownIcecek.Value + " adet " + comboBoxIcecek.Text);
            listBoxEkstra.Items.Add(ekstra);
            listBoxUcret.Items.Add(ucret + "TL");
        }

        private void buttonSiparisTemizle_Click(object sender, EventArgs e)
        {//Listbox'ları temizliyoruz.
            listBoxAdSoyad.Items.Clear();
            listBoxTelefon.Items.Clear();
            listBoxAdres.Items.Clear();
            listBoxPizza.Items.Clear();
            listBoxIcecek.Items.Clear();
            listBoxEkstra.Items.Clear();
            listBoxUcret.Items.Clear();

        }

        private void Temizle_Click(object sender, EventArgs e)
        {
            textBoxAdSoyad.Text = "";
            textBoxTelefon.Text = "";
            textBoxAdres.Text = "";
            //combobox değerlerini temizliyoruz
            comboBoxIcecek.Text = "";
            comboBoxPizzaBoy.Text = "";
            //numericupdown değerlerini temizliyoruz
            numericUpDownPizza.Value = 0;
            numericUpDownIcecek.Value = 0;

            //checkbox değerlerini temizliyoruz
            checkBoxSucuk.Checked = false;
            checkBoxSosis.Checked = false;
            checkBoxMantar.Checked = false;
            checkBoxKasar.Checked = false;
            checkBoxPeynir.Checked = false;
            checkBoxSebze.Checked = false;
        }

    }
}
