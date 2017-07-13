if (!ARGV[3].empty?) && (ARGV[3] != "false")
	require "chatwork"

	# Create message
	ChatWork.api_key = "#{ARGV[0]}"
	ChatWork::Message.create(room_id: "#{ARGV[1]}", body: "[info](#{ARGV[2]})[hr]Please Check! \nLink : https://github.com/#{ARGV[5]}/pull/#{ARGV[3]}[hr]#{ARGV[4]}[/info]")
end
