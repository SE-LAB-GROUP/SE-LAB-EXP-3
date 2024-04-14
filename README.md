### گام ۱: افزودن یک روش پیام رسانی دیگر
<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>1</strong></p>
</td>
<td width="198">
<p>TelegramMessage</p>
</td>
<td width="141">
<p>Add class</p>
</td>
<td width="292">
<p>The class has been added to project</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>2</strong></p>
</td>
<td width="198">
<p> TelegramMessageService</p>
</td>
<td width="141">
<p>Add class</p>
</td>
<td width="292">
<p>The class has been added to project</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>3</strong></p>
</td>
<td width="198">
<p> MessageService, EmailMessageService and SmsMessageService
</p>
</td>
<td width="141">
<p>Add method</p>
</td>
<td width="292">
<p>Add method sendTelegramMessage to MessageService, EmailMessageService and SmsMessageService</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>4</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>Add a case block</p>
</td>
<td width="292">
<p>Add a case block to switch-case in main for reading user's input when sending telegram message</p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>5</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>Add if statement</p>
</td>
<td width="292">
<p>Add a if statement to main for sending telegram message</p>
</td>
</tr>

</tbody>
</table>

مجموع تعداد تغییرات: ۵

### گام ۲: تحلیل و وارسی برنامه از منظر تحقق و یا عدم تحقق اصول SOLID

<table dir='rtl'>
<tbody>
<tr>
<td rowspan="2" width="240">
<p>اصل 1</p>
<p>Single Responsibility</p>
</td>
<td width="95">
<p><strong>موارد تحقق</strong></p>
</td>
<td width="454">
<p>Other message service and message type have a specific responsibility</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>MessageService does not have a specific responsibility (it have methods for sending SMS, Email and Telegram messages)</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 2</p>
<p>Open-Close Principle (OCP)</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>To add a new message type we can easily extend Message class</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>To add a new message service we need to implement all other sendX methods in MessageService</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 3</p>
<p>Liskov Substitution Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>We could use child classed instead of parent class (e.g. EmailMessageService can be used as a MessageService)</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 4</p>
<p>Interface Segregation Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>We need to implement all sendX method If we want to send only a specific type of message</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 5</p>
<p>Dependency Inversion Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>MessageService is dependant to its children and would cause problems</p>
</td>
</tr>
</tbody>
</table>

راهکارها:
