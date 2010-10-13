/*
 * This file is part of Mifos Helper.
 *
 * Mifos Helper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Mifos Helper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mifos Helper. If not, see <http://www.gnu.org/licenses/>.
 */

package com.adammonsen.mifos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;

import org.xnap.commons.i18n.I18n;
import org.xnap.commons.i18n.I18nFactory;

public class MifosHelper extends JFrame {
	private static final long serialVersionUID = 1L;

	public MifosHelper() {
		initi18n();
		initGuiComponents();
	}

	private static I18n i18n;

	private void initi18n() {
		i18n = I18nFactory.getI18n(MifosHelper.class);
		// force Spanish since my default is en_US
		i18n.setLocale(new Locale("es"));
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MifosHelper().setVisible(true);
			}
		});
	}

	private JLabel mifosConfLabel;
	private JTextField mifosConfTextField;
	private JButton testDatabaseConnectionButton;

	private void testDatabaseConnectionButtonActionPerformed(ActionEvent evt) {
		System.out.println("TODO: test db connection (in background)");
	}

	private void initGuiComponents() {
		mifosConfLabel = new JLabel("MIFOS_CONF"); // do not translate
		mifosConfTextField = new JTextField();
		mifosConfTextField.setText(System.getProperty("user.home") + File.separator + ".mifos");
		mifosConfTextField.setEditable(false);
		testDatabaseConnectionButton = new JButton();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(i18n.tr("Mifos Helper"));

		testDatabaseConnectionButton.setText(i18n.tr("Test database connection"));
		testDatabaseConnectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				testDatabaseConnectionButtonActionPerformed(evt);
			}
		});
		
		JPanel p = new JPanel(new MigLayout());
		p.add(mifosConfLabel);
		p.add(mifosConfTextField, "wrap");
		p.add(testDatabaseConnectionButton, "center, span");
		add(p);

		pack();
	}
}
